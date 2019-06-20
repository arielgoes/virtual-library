nome_arquivo = 'enderecosEditoras.txt'
arquivo = open(nome_arquivo, 'w')    
arquivo.seek(0)
rua = 'Rua da Editora '
numero = ['123', '456', '789']
complemento = 'Predio'
bairro = 'Bairro da Editora '
cidade = ['Alegrete', 'Santiago', 'Pelotas']
cep = ['12.123.123', '456.456.456', '78.789.789']

for i in range(3):
	texto = rua + str(i+1) + ';' + numero[i] + ';' + complemento + ';' + bairro + str(i+1) + ';' + cidade[i] + ';' + cep[i] + ';RS;Brasil' + '\n'
	arquivo.write(texto)
arquivo.close()
