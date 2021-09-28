# Codigo: HAL (hardware abstraction layer)
# Autora: Carla Edila Silveira
# Finalidade: funcoes para controlar temperatura, umidade, aquecedor

# inicio do codigo
import random


def temperatura():
    return random.randrange(2, 30)


def umidade():
    return random.randrange(10, 96)


def aquecedor(estado: str):
    if aquecedor == 'on':
        print('Aquecedor LIGADO')
    else:
        print('Aquecedor DESLIGADO')
# fim do codigo
