package Commands;

public class updatVarInfo 
{
		private String name;
		private Double value;
		public updatVarInfo(String name , Double value ) {
			this.name = name;
			this.value =value;
		}
		public String getName() {
			return name;
		}
		public Double getValue() {
			return value;
		}
}
