# Desafio Live On Solutions Android Nativo (Java)

O desafio consiste em desenvolver um aplicativo nativo Android, utilizando a linguagem Java. É uma simulação de um App para verificar suas assinaturas de carros alugados.

Para consumir o serviço da API Rest.


**Como usar:**

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

### O que será avaliado:
- Arquitetura escolhida para desenvolvimento do teste.
- Qualidade do código.
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

## Ganha + pontos se conter
- Persistência dos dados.
- Exibir os dados caso o app esteja offline.
- Animações em geral.
- App Universal, se ajustar para diferentes tipos de Devices.

### Sugestões ###
As sugestões de bibliotecas fornecidas são só um guideline, sintam-se a vontade para usar diferentes e nos surpreenderem. 
O importante de fato é que os objetivos macros sejam atingidos.

### Processo de submissão ###
O candidato deverá implementar a solução e enviar um pull request para este repositório com a solução.
O processo de Pull Request funciona da seguinte maneira:
1. Candidato fará um fork desse repositório (não irá clonar direto!)

2. Fará seu projeto nesse fork.

3. Commitará e subirá as alterações para o SEU fork.

4. Pela interface do GitHub, irá enviar um Pull Request.

Se possível deixar o fork público para facilitar a inspeção do código.

**ATENÇÃO**
Não se deve tentar fazer o PUSH diretamente para ESTE repositório!

Se você já entrou em contato com alguém da LiveOnSolutions sobre a vaga, além de fazer o Pull Request avise também essa pessoa por email, incluindo no email o seu usuário no GitHub.
