package com.yourssohail.understandingkoin

class EmployeeFactory(private val repository: EmployeeRepository) {

    fun saveEmployee(employee: Employee): String {
        repository.saveEmployee(employee)
        return "Saved at $this"
    }

}