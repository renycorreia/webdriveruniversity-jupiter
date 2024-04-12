#language: pt

Funcionalidade: Login

  Contexto: Estar na página de login
    Dado que estou na página de login

  @exceção
  Cenário: Realizar login sem preencher nenhum campo
    Dado que não preencho nenhum campo do formulário
    Quando clico no botão Login
    Entao é exibida a mensagem de alerta
      """
      validation failed
      """

  @exceção
  Esquema do Cenario: Realizar login sem preencher o campo <campo>
    Dado que não preencho o campo <campo>
    Quando clico no botão Login
    Entao é exibida a mensagem de alerta
      """
      validation failed
      """
    Exemplos:
      | campo      |
      | "username" |
      | "password" |

  @exceção
  Cenario: Realizar login com senha inválida
    Dado que preencho o campo username com um usuário válido
    Mas preencho o campo senha com um valor inválido
    Quando clico no botão Login
    Entao é exibida a mensagem de alerta
      """
      validation failed
      """