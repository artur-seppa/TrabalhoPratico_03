package Trabalho_pratico_3;

import java.util.Scanner;

public class Main {  
	
	public static void menu() {
		System.out.print("\n\t\tSISTEMA DE VENDA DE ROUPAS E ACESSORIOS USADOS\n\n");
		System.out.print("|------------------------------------------------|\n");
		System.out.print("|    1. Cadastrar Novo Usuario                   |\n");
		System.out.print("|    2. Cadastrar Novo Item                      |\n");
		System.out.print("|    3. Ver Carrinho de Compras                  |\n");
		System.out.print("|    4. Ver Lista de Roupas Favoritas            |\n");
		System.out.print("|    5. Visualizar Produtos Disponiveis          |\n");
		System.out.print("|    6. Ver Carrinho de Compras                  |\n");
		System.out.print("|    7. Imprimir Relacao Vendedor-Cliente        |\n");
		System.out.print("|    8. Publicar Novo Item                       |\n");
		System.out.print("|    0. Sair                                     |\n");
		System.out.print("|------------------------------------------------|\n");
		System.out.print("\nInsira a opcao desejada: ");
	}
	
	public static void main(String[] args) {
		
		//====== array de usuarios=======/
		//	100 usuarios sao criados
			Pessoa p[] = new Pessoa[100]; 
			
			Produto v[] = new Produto[100];
				
		//=============================/
		
		//====== logar usuario ======/
		p[1] = new Pessoa();
		p[1].setNome("Raul");
		p[1].setSexo("masc");
		p[1].setCpf("043485");
		//===========================/
		
		int opcao;
		
		do {
			menu();
			Scanner ler = new Scanner(System.in);
			opcao = ler.nextInt();
			
		switch (opcao) {

		case 1:
			System.out.println("\n\t---- CADASTRAR VENDEDOR ----\n");
    		
    		System.out.println("Digite o seu nome:");
    		String input;
    		input = ler.next();
    		
				Endereco e1 = new Endereco();
				e1.setCep(71925000);
				e1.setBairro("Àguas Claras");
				e1.setCidade("Brasília");
				
				Telefone t1 = new Telefone();
				t1.setDdd(221);
				t1.setTelefone(8922);
				
				//o usuario p[0] é instanciado
				p[0] = new Pessoa();
				p[0].setNome(input);
				p[0].setSexo("masc");
				p[0].setCpf("043485");
				
				//associa o objeto pessoa com telefone.
				p[0].setTelefone(t1);
				//associa o objeto pessoa com endereco.
				p[0].setEndereco(e1);
				
				System.out.println("o nome do usuario é : "+ p[0].getNome());
				System.out.println("o telefone da pessoa é "+ p[0].getTelefone().getTelefone());
				System.out.println("o endereco do usuario é " + p[0].getEndereco().getBairro());
				System.out.println("o cep do usuario é " + p[0].getEndereco().getCep());

			System.out.println("\nVendedor cadastrado com sucesso! ");
			break;

		case 2:
			System.out.println("\n\t---- CADASTRAR ITEM ----\n");

			System.out.println("Digite o seu item a ser cadastrado:");
    		input = ler.next();
    		
			Roupa r1 = new Roupa();
			r1.setCategoria("camiseta");
			r1.setQuantidadeEstoque(2);
			r1.setMarca("lost");
			r1.setPreco(110.99f);
			
			Roupa r2 = new Roupa();
			r2.setMarca("blunt");
			r2.setCategoria("casaco");
			r2.setPreco(99.00f);
			r2.setDescricao("casaco para frio");
			
			//associa o nome da pessoa ao produto.
			r1.setPessoa(p[1]);
			r2.setPessoa(p[1]);
			
			//associa o produto a pessoa.
			p[1].adicionarProduto(r1);
			p[1].adicionarProduto(r2);
			
//			System.out.println("nome de quem ta vendendo: "+ v1.getPessoa().getNome());
//			System.out.println("categoria : "+ v1.getCategoria());
//			System.out.println("marca : "+ v1.getMarca());
			
			//lista a marca de produtos associados a pessoa
			for(int i=0; i<p[1].quantidadeProdutos(); i++) {
				System.out.println(p[1].getProduto(i).getMarca());
			}
			
			//excluir um produto associado do Usuario
//			p[1].excluirProduto(v2);
//			System.out.println("testee");
			
			
			System.out.println("\nItem cadastrada com sucesso! ");
			break;

		case 3:
			System.out.println("\n\t---- CARRINHO DE COMPRAS ----\n");

			
			
			System.out.println("\nCategoria cadastrada com sucesso! ");
			break;

		case 4:
			System.out.println("\n\t---- ROUPAS FAVORITAS ----\n");

			System.out.println("\nPromoção cadastrada com sucesso! ");
			break;

		case 5:
			System.out.println("\n\t----  PRODUTOS DISPONIVEIS ----\n");
			
			Roupa r3 = new Roupa();
			r3.setMarca("DC");
			r3.setCategoria("camisa");
			r3.setPreco(99.00f);
			r3.setDescricao("camisa florida");
			
			Roupa r4 = new Roupa();
			r4.setMarca("Marvel");
			r4.setCategoria("camiseta");
			r4.setPreco(99.00f);
			r4.setDescricao("camiseta social");
			
			
			for (int i = 0; i<=1; i++) {
				System.out.println("Produto");
				System.out.println(r3.getMarca());
				System.out.println(r3.getCategoria());
			}

				//lista a marca de produtos associados a pessoa p[1].
				for(int i=0; i<p[1].quantidadeProdutos(); i++) {
					System.out.println("PRODUTO");
					System.out.println(p[1].getProduto(i).getMarca());
					System.out.println(p[1].getProduto(i).getDescricao());
					System.out.println(p[1].getProduto(i).getPreco());
					
					System.out.println("\n");
				}
			
			break;

		case 6:
			System.out.println("\n\t---- LISTA DE DESTAQUES ----\n");

			break;

		case 7:
			System.out.println("\n\t---- RELAÇÃO VENDEDOR E CLIENTE ----\n");

			break;

		case 8:
			System.out.println("\n\t---- PUBLICAR NOVO ITEM ----\n");

			System.out.println("\nItem publicado com sucesso! ");
			break;

		case 0:

			return;

		default:
			System.out.println("Opção inválida!");
			break;
		}
		
		}while(opcao != 0);
	}

}
