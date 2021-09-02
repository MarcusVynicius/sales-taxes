# Sales-taxes


__Regras de negócio da aplicação__

 * Todos os produtos tem taxa de 10% exceto livros,remédios e comida.
 * Caso o produto seja importado recebe 5% adicional ao imposto já acumulado.
 * Os impostos são somados antes do faturamento do produto, logo um produto taxável e importado teria 15% de imposto ( 10% normal e 5% de importação).
 * Produtos isentos por categoria devem receber imposto de importação (caso sejam importados).
 * Regra de arredondamento de cinco centavos pra cima quando o produto for taxado.
 * Após o faturamento deve ser impresso um recibo com os valores dos produtos já tributados, a soma dos tributos e o total da compra tributada. 

__Arquitetura__

* Clean
  * Abordagem no processo que levará o projeto a uma arquitetura limpa e desacoplada, separando a api, as regras do negócio, as entidades trazendo manutenbilidade e escalabilidade ao projeto.
* SpringBoot Aplication 
  * Para falicitar e ter um pacote inicial de dependências, visando utilizar o conceito de inversão de dependências
 * Api Rest
 
__Design do Código__

* Foram utilizados alguns dos princípios do ___SOLID___ pensando sempre na manutencão, entendimento e escalabilidade da aplicação.
  * __Responsabilidade única:__ Cada objeto no projeto foi pensado para ter apenas uma responsabilidade, como "representar uma entidade de domínio" ou "fazer arredondamento de valores" 
  * __Open/close:__ Foram criados os objetos de modo que se por ventura as regras de negócio mudarem não precisaríamos fazer alterações nas classes de serviço, apenas uma extensão das regras recebendo uma nova validação ou removendo-a. 
* Para validar os tipos dos produtos de acordo com a descrição recebida no input foi criada uma classe com um mapa para associação de palavras chaves de acordo com uma quebra no texto da descrição do produto.

__Metodologia de teste__: 

* __TDD:__ Foi iniciado o projeto de acordo com os testes para validar a criação das entidades e posteriormente as regras de tributação e seus cálculos, então dei seguimento criando os métodos de validação, tributação, arrendondamento e criação do recibo.
![testes sales taxes](https://user-images.githubusercontent.com/50083187/131892766-263578d2-9582-4153-8a4a-d3fbf02872d4.png)
![coverage sales taxes](https://user-images.githubusercontent.com/50083187/131892533-4b8d273d-bb28-464c-8ede-77fb80ab0bb5.png)

