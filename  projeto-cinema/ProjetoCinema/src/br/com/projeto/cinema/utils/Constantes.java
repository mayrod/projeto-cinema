package br.com.projeto.cinema.utils;

public final class Constantes 
{
	//TIPO SALA
	public static final int TIPO_SALA_2D = 1010;
	public static final int TIPO_SALA_3D = 1011;
	public static final int TIPO_SALA_2D_3D = 1012;
	
	//TIPO PAPEL - ELENCO
	public static final int TIPO_PAPEL_PROTAGONISTA = 2010;
	public static final int TIPO_PAPEL_CO_PROTAGONISTA = 2011;
	public static final int TIPO_PAPEL_ANTAGONISTA = 2012;
	public static final int TIPO_PAPEL_OPONENTE = 2013;
	public static final int TIPO_PAPEL_COADJUVANTE = 2014;
	public static final int TIPO_PAPEL_FIGURANTE = 2015;
	
	public static int getTipoSala(String tipo)
	{
		if(tipo.compareTo("2D")==0) 		{ return Constantes.TIPO_SALA_2D; 	}
		else if(tipo.compareTo("3D")==0) 	{ return Constantes.TIPO_SALA_3D; 	}
		else 								{ return Constantes.TIPO_SALA_2D_3D;}
	}
	
	public static int getTipoPalelProtagonista(String tipo)
	{
		if(tipo.compareTo("Protagonista")==0) 			{ return Constantes.TIPO_PAPEL_PROTAGONISTA; 	}
		else if(tipo.compareTo("Co-protagonista")==0) 	{ return Constantes.TIPO_PAPEL_CO_PROTAGONISTA; }
		else if(tipo.compareTo("Antagonista")==0) 		{ return Constantes.TIPO_PAPEL_ANTAGONISTA; 	}
		else if(tipo.compareTo("Oponente")==0) 			{ return Constantes.TIPO_PAPEL_OPONENTE; 		}
		else if(tipo.compareTo("Coadjuvante")==0) 		{ return Constantes.TIPO_PAPEL_COADJUVANTE; 	}
		else											{ return Constantes.TIPO_PAPEL_FIGURANTE; 		}
	}
	
	public static String getTipoPalelProtagonista(int tipo)
	{
		if(tipo==Constantes.TIPO_PAPEL_PROTAGONISTA) 			{ return "Protagonista"; 	}
		else if(tipo==Constantes.TIPO_PAPEL_CO_PROTAGONISTA) 	{ return "Co-protagonista"; }
		else if(tipo==Constantes.TIPO_PAPEL_ANTAGONISTA) 		{ return "Antagonista"; 	}
		else if(tipo==Constantes.TIPO_PAPEL_OPONENTE) 			{ return "Oponente"; 		}
		else if(tipo==Constantes.TIPO_PAPEL_COADJUVANTE) 		{ return "Coadjuvante"; 	}
		else											 		{ return "Figurante"; 		}
	}
}
