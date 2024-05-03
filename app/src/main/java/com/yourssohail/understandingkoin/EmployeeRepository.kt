package com.yourssohail.understandingkoin

interface EmployeeRepository {
    fun saveEmployee(employee: Employee)
    fun findEmployeeByPhoneNo(phoneNo: String): Employee?
}

class EmployeeRepositoryImpl: EmployeeRepository {
    private val employees = arrayListOf<Employee>()

    override fun saveEmployee(employee: Employee) {
        employees.add(employee)
    }

    override fun findEmployeeByPhoneNo(phoneNo: String): Employee? {
        return employees.firstOrNull { it.phoneNo == phoneNo }
    }

}