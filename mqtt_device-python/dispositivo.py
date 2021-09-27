# Codigo: Dispositivo MQTT
# Autora: Carla Edila Silveira
# Finalidade: implementar dispositivo MQTT

# inicio do codigo
import paho.mqtt.client as mqtt
import time
from hal import temperatura, umidade, aquecedor
from definitions import usuario, senha, cliente_id, servidor, porta


def mensagem(cliente, usuario, msg):
    if msg.topic == 'pucpr/iotmc/carla/aquecedor':
        aquecedor(msg.payload.decode()) #chama o metodo
    #print(msg.payload.decode())  #decode converte a msg binaria em formato str -->1o teste

# conexao inicial
cliente = mqtt.Client(cliente_id)  # criado objeto cliente para a classe Client
cliente.username_pw_set(usuario, senha)
cliente.connect(servidor, porta)  # acesso ao HiveMQ pelo link http://www.hivemq.com/demos/websocket-client/

cliente.on_message = mensagem  #call back da funcao
cliente.subscribe('pucpr/iotmc/carla/#')   #objeto conecta ao servidor e informa msg com topico de interesse
cliente.loop_start()  #instrui sistema para monitorar mensagens do broker e evocar a funcao mensagem

# comportamento do sistema para envio de informacoes
while True:
    cliente.publish('pucpr/iotmc/carla/temperatura', temperatura())  # criado topico sobre temperatura publish
    cliente.publish('pucpr/iotmc/carla/umidade', umidade())  # criado topico sobre umidade publish
    time.sleep(5)  # tempo de pausa 5seg para facilitar visualizacao no hive

# cliente.disconnect() --> desativado por causa do while que impede a execucao desta linha

# fim do codigo
