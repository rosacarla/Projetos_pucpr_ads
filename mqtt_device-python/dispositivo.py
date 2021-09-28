# Codigo: Dispositivo MQTT
# Autora: Carla Edila Silveira
# Finalidade: implementar dispositivo IoT de sistema monitor de estufa

# inicio do codigo
import paho.mqtt.client as mqtt
import time
from hal import temperatura, umidade, aquecedor
from definitions import usuario, senha, cliente_id, cliente_id2, servidor, porta


def mensagem(cliente, userdata, msg):
    vetor = (msg.payload.decode()).split(',')  #decode converte msg binaria em str e split separa str em 2 partes
    aquecedor('on' if vetor[1] == '1' else 'off')  #chama method aquecedor, passa estados (off/on) como parametros
    cliente.publish(f'v1/{usuario}/things/{cliente_id}/response', f'ok,{vetor[0]}')
    cliente2.publish(f'v1/{usuario}/things/{cliente_id2}/response', f'ok,{vetor[0]}')
    print(vetor)  #imprime mensagem srt dividida em 2 partes (chave e valor 1(lig) ou 0(desl)


# conexao inicial
cliente = mqtt.Client(cliente_id)  #criado objeto cliente para a classe Client
cliente2 = mqtt.Client(cliente_id2)  #criado objeto cliente2 para a classe Client
cliente.username_pw_set(usuario, senha)
cliente2.username_pw_set(usuario, senha)
cliente.connect(servidor, porta)  
cliente2.connect(servidor, porta)  #acesso a Cayenne pelo link https://cayenne.mydevices.com

cliente.on_message = mensagem  #call back funcao, objeto conecta ao servidor e informa msg chave + (1-lig/0-desl)
cliente2.on_message = mensagem  #call back funcao, objeto conecta ao servidor e informa msg chave + (1-lig/0-desl)
cliente.subscribe(f'v1/{usuario}/things/{cliente_id}/cmd/2')  #device1-aquecedor
cliente2.subscribe(f'v1/{usuario}/things/{cliente_id2}/cmd/5')  #device2-aquecedor
cliente.loop_start()  
cliente2.loop_start()  #instrui sistema para monitorar mensagens do broker e evocar a funcao mensagem

# comportamento do sistema para envio de informacoes
while True:
    cliente.publish('v1/' + usuario + '/things/' + cliente_id + '/data/0', temperatura())  # device1-criado topico temp
    cliente2.publish('v1/' + usuario + '/things/' + cliente_id2 + '/data/3', temperatura())  # device2-criado topico temp
    cliente.publish('v1/' + usuario + '/things/' + cliente_id + '/data/1', umidade())  # device1-criado topico umidade 
    cliente2.publish('v1/' + usuario + '/things/' + cliente_id2 + '/data/4', umidade())  # device2-criado topico umidade
    time.sleep(10)  # tempo de pausa 10 seg para facilitar visualizacao no display

# cliente.disconnect() --> desativado por causa do while que impede a execucao desta linha

# fim do codigo