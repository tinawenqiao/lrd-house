package com.designMode.singleton;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }











    @RequestMapping(value = "/QueryByIDCardNo")
    public String QueryByIDCardNo(String IDCardNo, Model model) {
        DataSourceContextHolder.setDataSourceType(DataSourceConst.SQLSERVER);
        //jdxx表
        List<PhysicalJdxx> physicalJdxxList = phsicalJdxxService.QueryByIDCardNo(IDCardNo);
        model.addAttribute("physicalJdxxList", physicalJdxxList);
        String ID_Patient=physicalJdxxList.get(0).getID_PATIENT();
        //zjs表
        
        List<PhysicalZis> physicalZisList = physicalZisService.PhysicalZisQueryById(ID_Patient );
        model.addAttribute("physicalZisList", physicalZisList);

        for (int i = 0; i <physicalZisList.size(); i++) {
            String ID_PATIENTEXAMDEPART=physicalZisList.get(i).getID_PATIENTEXAMDEPART();
            //zjsHy
            List<PhysicalZisHy> physicalZisHyList = physicalZisHyService.PhysicalZisHyQueryById(ID_PATIENTEXAMDEPART);

        }
        model.addAttribute("physicalZisHyList", physicalZisHyList);
//        //zjsMx
//        List<PhysicalZisMx> physicalZisMxList = physicalZisMxService.PhysicalZisMxQueryById(physicalZisHyList.get(0).getID_PatientExamDepart());
//        model.addAttribute("physicalZisMxList", physicalZisMxList);

        return "physical/PhysicalQueryAll";
    }






















    public void connectServer(String ip, int port, String user, String password, String path) {
        try {            /* ******连接服务器的两种方法*******/
            ftpClient = FtpClient.create();
            try {
                SocketAddress addr = new InetSocketAddress(ip, port);
                ftpClient.connect(addr);
                ftpClient.login(user, password.toCharArray());
                System.out.println("login success!");

            }
        }
    }


    public void upload(String localFile, String remoteFile) {
        this.localfilename = localFile;
        this.remotefilename = remoteFile;
        OutputStream os = null;
        FileInputStream is = null;
        try {
            try {
                os = ftpClient.putFileStream(this.remotefilename);
            } catch (FtpProtocolException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            File file_in = new File(this.localfilename);

            is = new FileInputStream(file_in);
            byte[] bytes = new byte[1024];
            int c;
            while ((c = is.read(bytes)) != -1) {
                os.write(bytes, 0, c);
            }
            System.out.println("upload success");
        } catch (IOException ex) {
            System.out.println("not upload");
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (os != null) {
                        os.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}