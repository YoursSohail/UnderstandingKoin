package com.yourssohail.understandingkoin

import androidx.lifecycle.ViewModel

class EmployeeViewModel(private val repository: EmployeeRepository): ViewModel() {

    fun saveEmployee(employee: Employee) {
        repository.saveEmployee(employee)
    }

    fun findEmployee(phoneNo: String) = repository.findEmployeeByPhoneNo(phoneNo)
}