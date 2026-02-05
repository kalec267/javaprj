package d260205_chatProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;

public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        /*ServerSocket server = new ServerSocket(8080);
        if(server==null){
            System.out.println("서버소켓오류");
        }
        System.out.println(server);*/

        /*try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println(server);
            if (server == null) {
                System.out.println("중간에 소캣 오류");
            }
        } catch (Exception e) {
            System.out.println("서버소켓오류");
        }*/

        /*
        Process p= Runtime.getRuntime().exec("notepad");
        Thread.sleep(3000);
//        p.destroy();
        System.out.println(p.pid());
        ProcessHandle.of(p.pid()).ifPresent(ph->{
            ph.destroyForcibly();
        });
        */

        /*Process p= Runtime.getRuntime().exec("cmd /c ipconfig");

        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "utf-8"));

        String line;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }*/

        /*ProcessBuilder pb=new ProcessBuilder("cmd","/c","dir");
        pb.inheritIO();
        pb.start();*/

        ProcessBuilder pb=new ProcessBuilder("notepad");
        pb.start();
        Thread.sleep(3000);
//        pb.wait(3000);


    }
}
