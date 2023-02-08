package backend;


import backend.element.Element;

public interface GameListener {
	
	default void gridUpdated(){
		//
	}
	
	default void cellExplosion(Element e){
		//
	}

}