# Projeto_Byte_Monstro

Ideias de projeto: 
 * https://actuar.com/software-para-academia#treino
 
## Integrantes do grupo 
 * Everton da Silva Souza - evertonsilva2345meia78@gmail.com
 * Joyce Mirelle Oliveira Santos - joycemirelleos.02@gmail.com

## Descrição geral do projeto 
O programa fará parte de uma rede de academias de musculação, seu principal objetivo é armazenar e manipular uma série dedados dos clientes da academia para que os profissionais da área possam, de forma rápida e prática montar e indicar melhores séries de treino para os clientes. Tanto os usuários da academia quanto os profissionais terão acesso ao sistema, assim como os administradores, porém os usuários estão limitados apenas a olhar e imprimir suas próprias informações (como por exemplo a ficha do treino diário), enquanto os profissionais poderão livremente manipular os dados dos clientes conforme a demanda e os administradores poderão manipular os dados tanto dos clientes como dos profissionais da área.

## Requisitos do projeto

 * *REQ1* - O sistema deve permitir o cadastro e o login dos administradores no sistema de gerenciamento das redes de academia.
 * *REQ2* - Os administradores tem acesso a todos os bancos de dados livremente (dos clientes da academia e dos profissionais) e eles podem livremente manipular dados tanto dos profissionais quanto dos clientes.
 * *REQ3* - O sistema deve permitir o cadastro (através dos administradores) e o login dos profissionais que trabalham em uma academia da rede.
 * *REQ4* - O sistema deve permitir o cadastro (através dos administradores ou os profissionais) de novos alunos mas não haverá sistema de login para os usuários.
 * *REQ5* - Cada profissional será responsável por uma quantidade de alunos, e apenas esses profissionais poderão alterar as fichas e os dados(REQ4) dos seus alunos.
 * *REQ6* - Cada aluno terá salvo em seu banco de dados uma ficha de treinos que vão representar suas listas de treinos diários, seu IMC, informações sobre seu peso e massa muscular.
 * *REQ7* - O aluno só poderá ter acesso a visualização e impressão das suas fichas de treino.
 * *REQ8* - Os profissionais poderão estipular uma quantidade máxima de vezes as quais os alunos poderão seguir uma sequencia de treinos, e após o aluno completar o numero máximo de vezes, o profissional deverá ser comunicado de alguma forma para que ele possa alterar o treino e fazer uma analise da evolução do aluno.
 * *REQ9* - Os profissionais, ao termino de uma sequência de treinos de um determinado aluno, poderão fornecer diversos relatórios ao aluno, como relatório da evolução da massa magra, de percentual de gordura, de IMC. Esses relatório podem ser impressos pelo aluno
 * *REQ10* - Alunos podem fazer requisição para a troca prematura da sua sequencia de treinos e os profissionais devem acatar ou não o pedido.
 * *REQ11* - Os administradores devem ser capazes de fazer a realocação de alunos de um profissional para o outro.
 * *REQ12* - Embora os dados dos clientes estejam disponíveis sem a necessidade de uma senha para acessa-los, será preciso digitar um numero único que é gerado na hora do cadastro do cliente para que ele possa imprimir e checar seus status, mas nem todas as informações estarão disponíveis para o publico, apenas sua ficha de treinos e seu gráfico de melhora física, o resto das informações como IMC e afins só poderão ser acessadas pelo administrador e pelo profissional.
