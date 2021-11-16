package com.sms.errors;

import java.util.ArrayList;
import java.util.List;

public class ValidationFailedResponse {

	private List<ValidationErrors> violations = new ArrayList<>();

	public List<ValidationErrors> getViolations() {
		return violations;
	}

	public void setViolations(List<ValidationErrors> violations) {
		this.violations = violations;
	}
}
