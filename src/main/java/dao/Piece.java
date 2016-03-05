package dao;

public class Piece {

		private String id;
		private String nomPiece;
		private String tableauPiece;

		public Piece(String id, String nomPiece, String tableauPiece) {
			super();
			this.id = id;
			this.nomPiece = nomPiece;
			this.tableauPiece = tableauPiece;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id= id;
		}

		public String getNomPiece() {
			return nomPiece;
		}

		public void setNomPiece(String nomPiece) {
			this.nomPiece = nomPiece;
		}

		public String getTab() {
			return tableauPiece;
		}

		public void setTab(String tableauPiece) {
			this.tableauPiece= tableauPiece;
		}
		@Override
		public String toString() {
			return "Piece [numéro=" + id+ ", Nom=" + nomPiece + ", Position=" + tableauPiece+ "]";
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id== null) ? 0 : id.hashCode());
			result = prime * result + ((nomPiece == null) ? 0 : nomPiece.hashCode());
			result = prime * result + ((tableauPiece == null) ? 0 : tableauPiece.hashCode());

			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Piece other = (Piece) obj;
			if (id== null) {
				if (other.id!= null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (nomPiece == null) {
				if (other.nomPiece != null)
					return false;
			} else if (!nomPiece.equals(other.nomPiece))
				return false;
			if (tableauPiece == null) {
				if (other.tableauPiece != null)
					return false;
			} else if (!tableauPiece.equals(other.tableauPiece))
				return false;
			return true;
		}

	}