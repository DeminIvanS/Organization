package org.example.model.enums;

public enum DepartmentPosition {
    ACCOUNTANT(Department.FINANCE),
    CHIEF_ACCOUNTANT(Department.FINANCE),
    FINANCIAL_DIRECTOR(Department.FINANCE),
    MASTER(Department.PRODUCTION),
    ENGINEER(Department.PRODUCTION),
    CHIEF_ENGINEER(Department.PRODUCTION),
    MECHANIC(Department.PRODUCTION),
    MANAGER(Department.SALES),
    SENIOR_MANAGER(Department.SALES);

    private final Department department;

    DepartmentPosition(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }
}
