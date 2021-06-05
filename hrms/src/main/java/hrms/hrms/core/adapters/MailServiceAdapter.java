package hrms.hrms.core.adapters;

import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.results.SuccessResult;

public class MailServiceAdapter implements MailService {

	@Override
	public Result verificate(String email) {
		return new SuccessResult("Mail checked");
	}
}
