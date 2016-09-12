package s_u.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class UploadForm extends ActionForm {
	private	FormFile[] myfiles=new FormFile[3];

	public FormFile getMyfile(int i) {
	return myfiles[i];
}

public void setMyfile(int i,FormFile myfile) {
	this.myfiles[i] = myfile;
}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}
}