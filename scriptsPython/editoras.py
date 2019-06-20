nome_arquivo = 'editoras.txt'
arquivo = open(nome_arquivo, 'w')    
arquivo.seek(0)
nomeEditora = ['EDITORA_1', 'EDITORA_2', 'EDITORA_3'] #split[0]
numEditora = ['(55)123456789', '(47)313646979', '(22)314253659'] #split[2]
cnpjEditora = ['08.357.578/0001-01', '10.468.689/0002-02', '12.863.986/0003-03'] #split[3]

#split[1] #Endereco endereco

ruaEditora = ['Rua Editora 1', 'Rua Editora 2', 'Rua Editora 3']


for i in range(len(nomeEditora)):sudo apt-get install sublime-text

	texto = nomeEditora[i] + ';' + enderecoEditora[i] + ';' + numEditora[i] + ';' + cnpjEditora[i] + '\n'
	arquivo.write(texto)
arquivo.close()
