import random

nome_arquivo = 'autores.txt'
arquivo = open(nome_arquivo, 'w')    
arquivo.seek(0)
autor = ['STEPHEN_KING', 'BERNARD_CORNWELL', 'KARL_MARX', 'CARL_SEGAN', 'LUDWIG_VON_MISES', 'HANS_HERMANN_HOPPE']
editora = ['EDITORA_1', 'EDITORA_2', 'EDITORA_3']

for a in range(len(autor)):
	texto = autor[a] + ';' + '00/00/0000;' + '00/00/0000;' + 'ALEGRETE;' + 'PORTO_ALEGRETE;' + 'UM MERO ESCRITOR;' + '\n'
	arquivo.write(texto)		
arquivo.close()
