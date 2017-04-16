package br.ufrn.view.internationalization;

/** 
 * The supported language
 * 
 * @author jadson
 *
 * <p><i>This program is distributed without any warranty and it
 * can be freely redistributed for research, classes or private studies, 
 * since the copyright notices are not removed.</i></p>
 *
 */
public enum Lingaguem{
	
	PORTUGUES((short) 0, "Português"), ENGLISH((short) 1, "English"), ESPANHOL((short) 2, "Español");
	
	private short valor;
	private  String descricao;
	
	Lingaguem(short valor, String descricao){
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public short getValor() { return valor; }
	public String getDescricao() { return descricao; }
	
}
