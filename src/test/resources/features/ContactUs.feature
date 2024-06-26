#language: pt

Funcionalidade: Contato

  Contexto: Estar na página de contato
    Dado que estou na página contato

  @exceção
  Cenário: Enviar formulário de contato sem preencher nenhum campo obrigatório
    Dado que não preencho nenhum campo do formulário
    Quando clico no botão SUBMIT
    Entao é exibida a mensagem de erro
      """
      Error: all fields are required
      Error: Invalid email address
      """

  @exceção
  Esquema do Cenario: Enviar formulário de contato preenchendo apenas o campo <campo>
    Dado que preencho apenas o campo <campo> do formulário
    Quando clico no botão SUBMIT
    Entao é exibida a mensagem de erro <msg>
    Exemplos:
      | campo           | msg                                                            |
      | "First Name"    | "Error: all fields are required\nError: Invalid email address" |
      | "Last Name"     | "Error: all fields are required\nError: Invalid email address" |
      | "Email Address" | "Error: all fields are required"                               |
      | "Comments"      | "Error: all fields are required\nError: Invalid email address" |

  @exceção
  Esquema do Cenario: Enviar formulário de contato sem o campo <campo> preenchido
    Dado que não preencho o campo <campo> do formulário
    Quando clico no botão SUBMIT
    Entao é exibida a mensagem de erro <msg>
    Exemplos:
      | campo           | msg                                                            |
      | "First Name"    | "Error: all fields are required"                               |
      | "Last Name"     | "Error: all fields are required"                               |
      | "Email Address" | "Error: all fields are required\nError: Invalid email address" |
      | "Comments"      | "Error: all fields are required"                               |

  @exceção
  Cenário: Enviar formulário de contato com e-mail em formato inválido
    Dado que preencho todos os campos do formulário corretamente
    Mas preencho o campo e-mail com um valor no formato inválido
    Quando clico no botão SUBMIT
    Entao é exibida a mensagem de erro
      """
      Error: Invalid email address
      """

  @sucesso
  Cenario: Enviar formulário de contato com todos os campos preenchidos
    Dado que preencho todos os campos do formulário corretamente
    Quando clico no botão SUBMIT
    Entao o formulário é enviado com sucesso, exibindo a mensagem de confirmação
      """
      Thank You for your Message!
      """

  @sucesso
  Cenario: Limpar todos os campos do formulário
    Dado que preencho todos os campos do formulário corretamente
    Quando clico no botão RESET
    Entao todos os campos do formulá são limpos novamente

