# Excursões Turísticas

Este projeto consiste em uma aplicação para gerenciamento de excursões turísticas oferecidas por uma empresa de turismo. A aplicação permite a reserva de excursões, tanto individualmente quanto em grupo, com a possibilidade de cancelamento e consulta de reservas. 

## Funcionalidades Principais

1. **Cadastro de Excursões**: É possível cadastrar diferentes excursões, cada uma identificada por um código único. Cada excursão possui um preço por pessoa e um número máximo de reservas.

2. **Reservas**: Os clientes podem realizar reservas para as excursões disponíveis, informando o CPF e o nome. A aplicação permite o cancelamento de reservas individualmente ou todas as reservas de um cliente.

3. **Consulta de Reservas**: É possível consultar as reservas realizadas tanto por CPF quanto por nome, filtrando por dígitos ou texto informados.

4. **Cálculo do Valor Total**: A aplicação calcula automaticamente o valor total da excursão considerando o número de reservas realizadas e o preço por pessoa.

5. **Persistência de Dados**: As informações das excursões e suas reservas são persistidas em arquivos .csv para que os dados sejam preservados entre sessões da aplicação.

## Como Utilizar

1. **Instalação e Configuração**: Clone o repositório em sua máquina local. Certifique-se de ter o Java JDK instalado para executar o código.

2. **Compilação e Execução**: Utilize um ambiente de desenvolvimento Java, como Eclipse ou IntelliJ, para compilar e executar a aplicação. Você também pode compilar manualmente utilizando o comando `javac` e executar com `java`.

3. **Interagindo com a Aplicação**: Após executar a aplicação, você poderá interagir com ela através de um menu interativo no console. Siga as instruções para cadastrar excursões, realizar reservas, consultar reservas, cancelar reservas e calcular o valor total.

4. **Persistência de Dados**: As informações das excursões e suas reservas serão automaticamente salvas em arquivos com extensão `.txt`. Certifique-se de que a aplicação tenha permissão para escrever e ler arquivos no diretório onde está sendo executada.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para propor melhorias!

## Autor

Este projeto foi desenvolvido por mim, Felipe Cartaxo. Você pode entrar em contato via [felipecartaxo1@gmail.com](felipecartaxo1@gmail.com) para mais informações.

## Licença

Sinta-se à vontade para utilizar e modificar o código conforme necessário.