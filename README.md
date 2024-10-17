# Conversor de Moedas

Este é um aplicativo de linha de comando (CLI) que permite a conversão entre diferentes moedas usando a API ExchangeRate. O aplicativo é simples e interativo, ideal para quem deseja realizar conversões de forma rápida e prática.

## Recursos

- Converte entre as seguintes moedas:
  - BRL (Real Brasileiro)
  - USD (Dólar Americano)
  - ARS (Peso Argentino)
  - BOB (Boliviano)
  - CLP (Peso Chileno)
  - COP (Peso Colombiano)
- Interface simples e interativa.
- Tratamento de entradas inválidas.

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter o seguinte instalado:

- [Java JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- Uma chave de API para a [ExchangeRate API](https://exchangerate-api.com/) (crie uma conta e obtenha sua chave).

## Instalação

Clone o repositório:
```
git clone https://github.com/Elineison/ConversorDeMoedas.git
cd ConversorDeMoedas
```
Compile o projeto usando Maven:
```
mvn compile
```
Execute o aplicativo em um terminal utilizando Maven:
```
mvn exec:java
```

Escolha uma das opções de conversão ou 0 para encerrar:

1. BRL para USD
2. USD para BRL
3. BRL para ARS
4. ARS para BRL
5. BRL para BOB
6. BOB para BRL
0. Sair

Siga as instruções na tela para realizar suas conversões. Escolha dentre as opções disponíveis e insira o valor que deseja converter!
