# Desafio Live On Solutions Android Nativo (Java)

# Fork - michel566

Como parte do processo seletivo, usaremos este desafio para avaliar suas habilidades com os requisitos da vaga. 

O teste prático deverá ser feito por você, no conforto da sua casa.

## Como entregar o desafio?

 - Faça um fork deste projeto em sua conta no [Github](https://github.com/join) (crie um repositório privado). 
 - Em seguida, desenvolva o projeto. 
 - Por fim, adicione como membro do repositório um dos usuários (@mtsrovari e @luoldrigues).

O desafio consiste em desenvolver um aplicativo nativo Android, utilizando a linguagem Java. É uma simulação de um App para verificar suas assinaturas de veículos alugados.

### Diretrizes

- Tela Login: Manter usuário logado, apenas voltar para tela de Login caso clique no botão `Sair`. Método `POST Auth`.
- Tela Meu Perfil: Essa tela, o usuário terá acesso as suas informações e o `Status de Acompanhamento` do(s) veículo(s). Método `GET User Profile`.
- Tela Minhas Assinaturas: Listagem das assinaturas do usuário logado. Método `GET Orders`.
- Tela Detahes da Assinatura: Detalhes da assinatura escolhida na tela anterior. Método `GET Order Details`.

**Para consumir o serviço da API Rest:**

> - **URL** https://challenge-mobile-api.liveonsolutions.com/api/v1/auth
> - **Método**: `POST` Auth - Retornará uma `Token` do padrão `JWT` que será utilizadas para fazer a requisição dos demais métodos.

> - **URL** https://challenge-mobile-api.liveonsolutions.com/api/v1/user/profile?token={{token}}
> - **Método**: `GET` User Profile - Retornará a os dados para montar a tela de Perfil juntamente com o status de acompanhamento do(s) veículo(s) alugado(s).

> - **URL** https://challenge-mobile-api.liveonsolutions.com/api/v1/user/profile/orders?token={{token}}
> - **Método**: `GET` Orders - Método responsável por retornar a listagem de veículo(s) alugado(s).

> - **URL** https://challenge-mobile-api.liveonsolutions.com/api/v1/user/profile/order_details?token={{token}}&order_id=1102
> - **Método**: `GET` Order Details - Responsável por retornar o detalhe do(s) veículo(s) alugado(s).

#### Para fins de teste, os usuários a seguir serão reconhecidos ao passarem pelo método `Auth`. Qualquer outro é barrado ao tentar fazer Login.

> - **email** jessica@challenge.com
> - **password**: pass123

> - **email** john@challenge.com
> - **password**: pass123


#### O layout está disponível em https://xd.adobe.com/view/c3f7258b-cdf9-481e-4ad3-98b0648f083f-b5c6/
#### A Documentação da API, juntamente com o Postman está disponível em https://documenter.getpostman.com/view/3081743/SW18vaEg?version=latest


### A solução deverá conter:
- Retrofit para comunicação com a API.
- Versão mínima do SDK: 21.
- Desenvolvimento em Java.
- Cumprir os requisitos.
- Seguir Mockups.

### O que será avaliado
- Fidelidade ao Layout / Mockup
- Integração com a Api
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

