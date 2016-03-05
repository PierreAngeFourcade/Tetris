package dao;

public class Face {

		private String id;
		private String nomFace;


		public Face(String id, String nomFace) {
			super();
			this.id = id;
			this.nomFace = nomFace;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id= id;
		}

		public String getNomFace() {
			return nomFace;
		}

		public void setNomFace(String nomFace) {
			this.nomFace = nomFace;
		}

		
		@Override
		public String toString() {
			return "Face [numéro=" + id+ ", Nom=" + nomFace + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id== null) ? 0 : id.hashCode());
			result = prime * result + ((nomFace == null) ? 0 : nomFace.hashCode());
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
			Face other = (Face) obj;
			if (id== null) {
				if (other.id!= null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (nomFace == null) {
				if (other.nomFace != null)
					return false;
			} else if (!nomFace.equals(other.nomFace))
				return false;
			return true;
		}

	}