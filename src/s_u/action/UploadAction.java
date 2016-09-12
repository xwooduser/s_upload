package s_u.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import s_u.form.UploadForm;

public class UploadAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		UploadForm uploadForm = (UploadForm) form;// TODO Auto-generated method stub
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		String fileName="";
		ServletContext app=this.getServlet().getServletContext();
		String realPath=app.getRealPath("/files/");
		StringBuffer reFileStr=new StringBuffer("");
		//批量上传
		for(int i=0;i<3;i++)
		{
			FormFile myfile;
			try {
				myfile = uploadForm.getMyfile(i);
				fileName=myfile.getFileName();
			} catch (Exception e) {
				break;
			}
			if (fileName == null || fileName.length() == 0) {
				continue;
			}
			File _f=new File(realPath+"/"+myfile.getFileName());
			//if(!_f.exists())
			//_f.mkdirs();
			FileOutputStream fos=null;
			try{
				byte[] data= myfile.getFileData();
				try {
					fos = new FileOutputStream(realPath + "/"
							+ myfile.getFileName(), false);
				} catch (FileNotFoundException ee) {
				System.out.println("拒绝访问----");
				}
				fos.write(data);
				reFileStr.append(basePath+"files/"+fileName + ";");
			}catch(Exception ex)
			{ex.printStackTrace();}finally{try{fos.close();}catch(Exception ex){}};
		}
		response.setContentType("text/html;charset=utf-8"); 
		try {
			if (reFileStr.length() > 0) {
				reFileStr.deleteCharAt(reFileStr.length() - 1);
				response.getWriter().write(reFileStr.toString());
			} else {
				response.getWriter().write("请至少选择一个待上传文件！");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}