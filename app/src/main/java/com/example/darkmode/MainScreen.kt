package com.example.darkmode

import android.graphics.Paint.Align
import android.graphics.drawable.shapes.Shape
import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CardView(image:Int,title:String) {
Card(modifier= Modifier
    .width(100.dp)
    .height(200.dp)
    .clip(RoundedCornerShape(5))
    .padding(5.dp)) {

    Box(modifier =Modifier.fillMaxSize()){

        Image(modifier=Modifier.fillMaxSize(),
            painter = painterResource(id = image)  , contentDescription = title)

       Box(contentAlignment = Alignment.BottomCenter,
           modifier = Modifier
               .fillMaxSize()
               .background(
                   brush = Brush.verticalGradient(
                       colors = listOf(
                           Color.Transparent,
                           Color.Black
                       ), startY = 300f
                   )
               )){


           Text(modifier=Modifier.padding(10.dp),text=title,textAlign= TextAlign.Center,
               fontSize =15.sp, color=Color.White)

          }

      }

  }

}

data class Card(val image:Int,val title:String)
var item1=Card(R.drawable.shankara ,"Shankara Charya" )
var item2=Card(R.drawable.chatrapati,"Chatrapati Shivaji")
var item3= Card(image = R.drawable.viveka , title ="Swami Vivekananda" )
var item4=Card(R.drawable.savarkar,"Veer Savarkar")
val list= listOf(item1, item2, item3, item4)

@Composable
fun CardViews(items:List<Card>){
    LazyRow(){
        items(items){
            item->
            CardView(item.image,item.title)
        }
    }

}



@Composable
fun mainScreen(bg:MutableState<Color>,txt:MutableState<Color>,str:MutableState<String>){
    Column(modifier= Modifier
        .fillMaxSize()
        .background(bg.value)) {

IconButton(modifier=Modifier.align(Alignment.End)
    ,onClick = {
         if(str.value=="Light") str.value ="Dark" else str.value="Light"
        if(bg.value == Color.White)  bg.value= Color.Black else bg.value=Color.White
    if(txt.value == Color.Black)  txt.value= Color.White  else txt.value=Color.Black },colors =IconButtonDefaults.filledIconButtonColors(),) {
    Icons.Default.Face
    Text(text =str.value,
    color =txt.value,
    fontSize =15.sp)
           }
 Text(modifier=Modifier.padding(10.dp),text ="Legends Of Bharat",
 color=txt.value,
 fontSize =40.sp)
       CardViews(items = list)

      }
      
  }

@Preview //meta data
@Composable
fun review(){
    val str= remember {
        mutableStateOf("Light")
    }
    val bg= remember {
        mutableStateOf(Color.White)
    }
    val txt = remember {
        mutableStateOf(Color.Black)
    }
    mainScreen(bg =bg , txt =txt,str )
}

