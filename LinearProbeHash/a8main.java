
public class a8main {
	

	public static void main(String[] args) {
			LinearProbeHash probe = new LinearProbeHash(10);
			probe.hashInsert("6150");
			probe.hashInsert("Hello!");
			probe.hashInsert("100%");
			probe.hashInsert("John");
			probe.hashInsert("Main St.");
			probe.hashInsert("Hi");
			probe.hashInsert("$350");
			probe.hashInsert("3.25");
			probe.hashInsert("45");//^^these test the INSERT method and COLLISIONS
			probe.hashInsert("anEmail@aol.com");//array is FULL after this line
			probe.hashInsert("y=mx+b");//test for FULL table
			probe.hashDelete("100%");//test DELETE , placement of TOMBSTONE
			probe.hashInsert("Dave");//tests INSERT into TOMBSTONE
			probe.hashFind("$350");//tests FIND function, used a test case that originally collided when inserted
			probe.showArray();
			
	}
	

}
