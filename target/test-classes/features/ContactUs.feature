#language: pt

  Funcionalidade: Contato

    Contexto: Estar na página de contato
      Dado que estou na página contato

    Cenário: Enviar formulário de contato sem preencher campos obrigatórios
      Dado que não preencho nenhum campo do formulário
      Quando clico no botão SUBMIT
      Entao é exibida a mensagem de erro
      """
      Error: all fields are required
      Error: Invalid email address
      """