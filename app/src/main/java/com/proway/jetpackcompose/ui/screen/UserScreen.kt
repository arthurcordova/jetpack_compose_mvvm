package com.proway.jetpackcompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.proway.jetpackcompose.R
import com.proway.jetpackcompose.view_model.UserViewModel

@Composable
fun UserScreen(userViewModel: UserViewModel = viewModel()) {
    val name : String by userViewModel.name.observeAsState("")
    UserContent(name = name, onNameChanged = {userViewModel.onNameChanged(it)})
}

@Composable
fun UserContent(name:String, onNameChanged: (String) -> Unit) {
    Card(
        modifier = Modifier.padding(all = 32.dp),
        elevation = 12.dp
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(40.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape)
            )

            Column(modifier = Modifier.padding(12.dp)) {
                OutlinedTextField(
                    value = name,
                    onValueChange = onNameChanged,
                    label = { Text("Name") })
                Text("Texto informado: $name")
            }
        }
    }
}