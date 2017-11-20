import java.util.*;

public class ArvoreBinaria<E extends Comparable<E>>{
    private Node refRoot;
	private int count;
    
    private class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
    	private Node<T> father;
    	private Node<T> left;
    	private Node<T> right;
    	private T item;
    	
    	public Node(T element) {
    		this.item = element;
    		this.father = null;
    		this.left = null;
    		this.right = null;
    	}
    
		public Node<T> getFather() {
			return father;
		}

		public void setFather(Node<T> father) {
			this.father = father;
		}

		public Node<T> getLeft() {
			return left;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
		}

		public Node<T> getRight() {
			return right;
		}

		public void setRight(Node<T> right) {
			this.right = right;
		}

		public T getItem() {
			return item;
		}

		public void setItem(T item) {
			this.item = item;
		}

		@Override
		public int compareTo(Node<T> outro) {
			return item.compareTo(outro.item);			
		}
    	
    	   	
    }
    
    public ArvoreBinaria() {
    	this.count = 0;
    	this.refRoot = null;
    }
        
    
    public enum NodePosition {
    	LEFT, RIGHT
    }
    
    public ArvoreBinaria(E [] vet) { 
    	List <Node<E>> fila = new LinkedList<Node<E>>(); 
        int i; 
        Node<E> novo = null, primeiro = null;

        NodePosition pos = null;
        this.count = vet.length;

        if (vet.length > 0) { 
            novo = new Node<E>(vet[0]); 
            refRoot = novo;
            fila.add(0, novo); 
            pos = NodePosition.LEFT;

            for(i = 1; i < vet.length; i++) {
                     novo = new Node<E>(vet[i]); 
                     fila.add(novo);
                     primeiro = fila.get(0); 
                     novo.setFather(primeiro);

                     if (pos.equals(NodePosition.LEFT)) { 
                        primeiro.setLeft(novo); 
                        pos = NodePosition.RIGHT;
                     } 
                    else { 
                        primeiro.setRight(novo); 
                        fila.remove(0); 
                        pos = NodePosition.LEFT; 
                     } 
              } 
          } 
    }
    
    public List<E> traversalPre(){
    	List<E> res = new ArrayList<E>();
    	traversalPre(refRoot,res);
    	return res;
    }
    
    private void traversalPre(Node<E> n, List<E> res) {
    	while (n!=null) {
    		res.add(n.getItem());
    		traversalPre(n.getLeft(),res);
    		traversalPre(n.getRight(),res);
    	}
    }
    
        
    public List<E> traversalPos(){
    	// Percorre sub arvore da esquerda
    	// Percorre sub arvore da direita
    	// Visita raiz 
    	
    	List<E> res = new ArrayList<E>();
    	traversalPos(refRoot,res);
    	return res;   	
    }
    
    private void traversalPos(Node<E> n, List<E> res) {
    	while(n!=null) {
    		traversalPos(n.getLeft(),res);
    		traversalPos(n.getRight(),res);
    		res.add(n.getItem());
    	}
    }
    
    /*
        
    
    public List<E> traversalCentral(){
    	return 0;
    }
    
    public List<E> traversalWidth(){
    	return 0;
    }
    
    
    private Node searchNodeRef(E item) {
    //que percorre a árvore em busca do item e retorna uma referência para o Node que o armazena;
    }

    public boolean add(E item, E pai, NodePosition pos) {
    //Adiciona o elemento item como filho do elemento pai na posição (LEFT ou RIGHT) pos;
    }

    public boolean removebranch(E item) {
    	
    }
    
    public int count() {
    //que percorre a árvore e conta quantos elementos estão armazenados (sem utilizar outros métodos da classe árvore);
    }

    public int count(E item) {
    //que percorre a árvore e conta quantas ocorrências de item estão armazenados na árvore (sem utilizar outros métodos da classe árvore);
    }

    public boolean isInternal(E item) {
    //testa se um nodo item é interno; 
    }

    public boolean isExternal(E item) {
    //testa se um nodo v é externo (raíz ou folha);
    }

    public boolean isProper() {
    //retorna true se árvore binária for própria. Uma árvore binária é própria se cada um de seus nodos tiver, exatamente, zero ou dois filhos.
    }
    
    */
    	
	
}
 	