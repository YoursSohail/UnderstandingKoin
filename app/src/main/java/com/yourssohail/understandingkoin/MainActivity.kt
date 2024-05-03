package com.yourssohail.understandingkoin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yourssohail.understandingkoin.ui.theme.UnderstandingKoinTheme
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnderstandingKoinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.verticalScroll(rememberScrollState())
                    ) {
                        EmployeeInfo()
                        EmployeeFactory1()
                        EmployeeFactory2()
                    }
                }
            }
        }
    }

    @Composable
    fun EmployeeInfo(viewModel: EmployeeViewModel = koinViewModel()) {
        var name by remember {
            mutableStateOf("")
        }
        var phoneNo by remember {
            mutableStateOf("")
        }
        var address by remember {
            mutableStateOf("")
        }
        var phoneNoToSearch by remember {
            mutableStateOf("")
        }
        var employeeFound by remember {
            mutableStateOf<Employee?>(null)
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = " -------- EmployeeInfo -------- ")
            TextField(
                value = name,
                placeholder = {
                    Text(text = "Enter name")
                },
                onValueChange = {
                    name = it
                }
            )
            TextField(
                value = phoneNo,
                placeholder = {
                    Text(text = "Enter phone no")
                },
                onValueChange = {
                    phoneNo = it
                }
            )
            TextField(
                value = address,
                placeholder = {
                    Text(text = "Enter address")
                },
                onValueChange = {
                    address = it
                }
            )
            Button(onClick = {
                viewModel.saveEmployee(Employee(name, phoneNo, address))
                name = ""
                phoneNo = ""
                address = ""
            }) {
                Text(text = "Save")
            }
            TextField(
                value = phoneNoToSearch,
                placeholder = {
                    Text(text = "Enter phone no to search")
                },
                onValueChange = {
                    phoneNoToSearch = it
                }
            )
            Button(onClick = {
                employeeFound = viewModel.findEmployee(phoneNoToSearch)
            }) {
                Text(text = "Find Employee")
            }
            employeeFound?.let {
                Column {
                    Text(text = it.name)
                    Text(text = it.phoneNo)
                    Text(text = it.address)
                }
            }
        }

    }

    @Composable
    fun EmployeeFactory1(factory: EmployeeFactory = koinInject()) {
        var name by remember {
            mutableStateOf("")
        }
        var phoneNo by remember {
            mutableStateOf("")
        }
        var address by remember {
            mutableStateOf("")
        }
        var displayMessage by remember {
            mutableStateOf("")
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = " -------- EmployeeFactory1 -------- ")
            TextField(
                value = name,
                placeholder = {
                    Text(text = "Enter name")
                },
                onValueChange = {
                    name = it
                }
            )
            TextField(
                value = phoneNo,
                placeholder = {
                    Text(text = "Enter phone no")
                },
                onValueChange = {
                    phoneNo = it
                }
            )
            TextField(
                value = address,
                placeholder = {
                    Text(text = "Enter address")
                },
                onValueChange = {
                    address = it
                }
            )
            Button(onClick = {
                displayMessage = factory.saveEmployee(Employee(name, phoneNo, address))
                name = ""
                phoneNo = ""
                address = ""
            }) {
                Text(text = "Save")
            }
            Text(text = displayMessage)
        }
    }

    @Composable
    fun EmployeeFactory2(factory: EmployeeFactory = koinInject()) {
        var name by remember {
            mutableStateOf("")
        }
        var phoneNo by remember {
            mutableStateOf("")
        }
        var address by remember {
            mutableStateOf("")
        }
        var displayMessage by remember {
            mutableStateOf("")
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = " -------- EmployeeFactory2 -------- ")
            TextField(
                value = name,
                placeholder = {
                    Text(text = "Enter name")
                },
                onValueChange = {
                    name = it
                }
            )
            TextField(
                value = phoneNo,
                placeholder = {
                    Text(text = "Enter phone no")
                },
                onValueChange = {
                    phoneNo = it
                }
            )
            TextField(
                value = address,
                placeholder = {
                    Text(text = "Enter address")
                },
                onValueChange = {
                    address = it
                }
            )
            Button(onClick = {
                displayMessage = factory.saveEmployee(Employee(name, phoneNo, address))
                name = ""
                phoneNo = ""
                address = ""
            }) {
                Text(text = "Save")
            }
            Text(text = displayMessage)
        }
    }

}
