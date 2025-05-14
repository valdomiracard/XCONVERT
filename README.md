![XCONVERT]![finances (1)](https://github.com/user-attachments/assets/d786b555-a805-4525-9170-db44ec7c1bcc)


## XConvert - Conversor de Moedas em Tempo Real

**Converta moedas em tempo real com versatilidade e praticidade!**

---

## Sobre o Projeto

O **XConvert** é uma aplicação desenvolvida em **Java** com o objetivo de oferecer uma experiência dinâmica e eficaz na conversão de moedas. Utilizando uma API externa de câmbio, o sistema permite a obtenção de taxas de conversão atualizadas, garantindo precisão nas operações.

Desenvolvido por [Valdomira Cardoso](https://github.com/valdomiracard), este projeto é ideal para quem deseja explorar conceitos como:

- Requisições HTTP com `HttpClient`
- Manipulação de JSON com `Gson`
- Boas práticas com estrutura em camadas
- Registro de logs com `java.time`
- Armazenamento e exibição de histórico

---

 ## Funcionalidades

✔ Conversão de moedas em tempo real  
✔ Histórico das conversões feitas  
✔ Registro de logs com data e hora das operações  
✔ Menu interativo no console  
✔ Expansível para novas moedas com facilidade

---

 ## Estrutura do Projeto

```plaintext
src/
├── principal/
│   └── Principal.java
├── servico/
│   └── ConversorMoedas.java
├── modelo/
│   └── Moeda.java
├── util/
│   └── GeradorArquivo.java
│   └── RegistroHistorico.java
