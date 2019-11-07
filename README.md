# Desafio Live On Solutions Android Nativo (Java)

O desafio consiste em desenvolver um aplicativo nativo Android, utilizando a linguagem Java. É uma simulação de um App para verificar suas assinaturas de veículos alugados.

Ao fazer o `Login` o usuário será redirecionado para a tela de Perfil, lá ele terá acesso as suas informações e o `Status de Acompanhamento` do(s) veículo(s). Terá os botões de `Minhas Assinaturas` e `Sair`. Clicando no botão sair, perguntar se ele realmente deseja sair. Caso clique em `Minhas Assinaturas` redirecionar para a tela onde listará todas as assinaturas do mesmo. E por fim, no final do Flow, escolhendo o veículo, uma tela de Detalhes será chamada, essa tela contém todas as informações do veículo alugado. Tais como Imagens, Modelo, Ano, Marca.. entre outras informações.

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

Devem ser usadas boas práticas de programação, assim como padrões de projeto e Arquitetura.

### A solução deverá usar:
- Retrofit para comunicação com a API.
- Versão mínima do SDK: 21
- Utilizar Java.

### O que esperamos
- Arquitetura escolhida para desenvolvimento do teste.
- Qualidade do código.
- App Universal, tela se ajustar para diferentes tipos de Devices.
- Adoção de boas práticas recomendadas pela comunidade Android.
- Funcionamento do produto entregue.

### Entrega de valor
- Funcionar
- Cumprir os requisitos
- Usabilidade
- Interface

### Boas Práticas
- Domínio da linguagem de programação
- Estrutura do código
- Organização do código
- Uso adequado de controle de versão

## Plus
- Persistência dos dados.
- Dados offiline (cache dos dados).
- Animações em geral.

### Publicação ###
Crie um Fork do repositório para realizar o teste, e depois de finalizado envie um Pull Request para nossa equipe interna avaliar.
