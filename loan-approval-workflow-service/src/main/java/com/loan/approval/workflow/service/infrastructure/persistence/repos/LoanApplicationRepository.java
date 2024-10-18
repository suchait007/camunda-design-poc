package com.loan.approval.workflow.service.infrastructure.persistence.repos;

import com.loan.approval.workflow.service.domain.models.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, String> {
}
