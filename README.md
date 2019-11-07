# Desafio Live On Solutions Android Nativo (Java)

Como parte do processo seletivo, usaremos este desafio para avaliar suas habilidades com os requisitos da vaga. 

O teste prático deverá ser feito por você, no conforto da sua casa.

## Como entregar o desafio?

 - Faça um fork deste projeto em sua conta no [Github](https://github.com/join) (crie um repositório privado). 
 - Em seguida, desenvolva o projeto. 
 - Por fim, adicione como membro do repositório um dos usuários (@mtsrovari ou @luoldrigues).

O desafio consiste em desenvolver um aplicativo nativo Android, utilizando a linguagem Java. É uma simulação de um App para verificar suas assinaturas de veículos alugados.

### Diretrizes

- `Login` (Manter usuário logado, apenas voltar para tela de Login caso clique no botão `Sair`)
- `Meu Perfil` (Essa tela, o usuário terá acesso as suas informações e o `Status de Acompanhamento` do(s) veículo(s), a partir do método `GET User Info`).
- Listagem das Minhas Assinaturas.
- Detalhes da Minha Assinatura.

**Para consumir o serviço da API Rest:**

> - **URL** https://www.liveonbank.com.br/
> - **Método**: `POST` Login - Retornará uma `Token` do padrão `JWT` que será utilizadas para fazer a requisição dos demais métodos.

> - **URL** https://www.liveonbank.com.br/
> - **Método**: `GET` User Info - Retornará a os dados para montar a tela de Perfil juntamente com o status de acompanhamento dos carros alugados.

> - **URL** https://www.liveonbank.com.br/
> - **Método**: `GET` User Subscriptions - Método responsável por retornar a listagem de veículos alugados.

> - **URL** https://www.liveonbank.com.br/
> - **Método**: `GET` Subscription Details - Responsável por retornar o detalhe do veículos alugado.


O layout está disponível em https://xd.adobe.com/spec/a6abafc2-8aca-4b77-4859-5b64ec81d7a9-d09a/


### A solução deverá conter:
- Retrofit para comunicação com a API.
- Versão mínima do SDK: 21
- Utilizar Java.
- Cumprir os requisitos
- Seguir Mockus

### O que será avaliado
- Arquitetura escolhida para desenvolvimento do desafio.
- Qualidade do código.
- App Universal, tela se ajustar para diferentes tipos de Devices.
- Adoção de boas práticas recomendadas pela comunidade Android.
- Funcionamento do desafio entregue.
- Organização de pastas (Activities, Adapters, Utils, Model.. etc).
- Usabilidade.

### Boas Práticas
- Domínio da linguagem de programação.
- Estrutura do código.
- Organização do código.
- Uso adequado de controle de versão.

## Plus
- Persistência dos dados (chache dos dados).
- Dados offiline (cache dos dados).
- Animações em geral.

### Publicação ###
Seu projeto será avaliado de acordo com a qualidade do seu código e sua organização com os arquivos utilizados, além do conhecimento e bom uso da linguagem Java.

Dê-nos acesso ao seu repositório, quando fizer isto, avise-nos por e-mail vagas@liveonbaas.com, avaliaremos o mais rápido possível e te daremos o feedback.

_Boa sorte!_


<a target='_blank'><img align="right" class='header-img' width=230px height=180px src='https://raw.githubusercontent.com/LiveOnSolutions/challenge-android/master/assets/yoda.png' /></a>

