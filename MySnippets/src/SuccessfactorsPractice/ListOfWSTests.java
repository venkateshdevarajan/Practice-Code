

/*@TestlinkInfo( { "testcaseid = ENT23612" })
    @Test(groups = { "recruiting2_0", "RCM_WebService","Harmony_All"})
    public void testENT23612() throws Exception
    {
    	updateARP("ENT23612");    	
    }*/
    
   

public class ListOfWSTests {
	public static void main(String[] args){
		
		String[] testCases = { "13244","13257","13399","13401","13409","13410","19441","19524","20596","20610","20611","20612","19528","19531","19561","19562","19583","19584","19593","19671","20739","20740","20741","20742","19414","19418","19511","19515","19595","19430","19518","19597","19434","19435","19517","19596","23577","23605","23609","23610","23620","23621","23631","23646","23651","23652","23654","23655","23656","23657","23661","23586","23587","23588","23591","31248","31250","19412","19411","19410","13222","23612","23637","23414","23412","23592","17762","20585","20602","20735","13242","13243","19427","19428","19429","19426","13225","23658","23659","23584","23585","13237","33023","13232","13224","13229","13233","17766","19422","19415","17764","17763","13240","13406","13407","28713","19409","19513","19594","23417","23421","23419","23422","23423","23568","23569","23570","23571","23590","13226","23604","23598","23596","23595","23594","23572","23575","23593","23599","23600","23601","23643","23642","23622","23623","23624","19438","23589","23660","23644","23641","19519","19440","19439","19437","19523","13402","13404","19431","19432","19433","33260","23578","23603","13230","33902","19423","33903","19424","33904","19421","19425","20755","13241","20747","13227","13234","19417","33905","19416","33906","13239","20597","17768","19525","19526","19530","19563","19564","20587","20588","19527","19598","20589","20590","20598","20599","20600","20603","20604","20605","20607","23597","20608","20609","23613","23614","23615","23617","23618","23619","23625","23626","23627","23628","23629","23632","23633","23634","23636","23638","23639","23640","23647","23649","23650","23408","13235","13238","13236","17765","23580","23606","23607","23635"};
		for(int i=0;i<testCases.length;i++){
			String struct = "@TestlinkInfo({\"testcaseid = SNIPPET\"})\n"+
					 "@Test(groups = { \"recruiting2_0\", \"RCM_WebService\",\"Harmony_All\"})\n"+
					 "public void testSNIPPET() throws Exception\n"+
					 "{\n"+
					 "\t updateARP(\"SNIPPET\");\n"+
					 "}\n";
			struct = struct.replace("SNIPPET", "ENT"+testCases[i]);
			System.out.println(struct);
			System.out.println();
		}
    
	}

}
