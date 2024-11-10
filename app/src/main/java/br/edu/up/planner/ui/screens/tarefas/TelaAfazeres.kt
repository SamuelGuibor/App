package br.edu.up.planner.ui.screens.tarefas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.up.planner.ui.screens.util.PlannerTopBar
import br.edu.up.planner.ui.screens.util.TelaUmBottomBar

object TarefasRota {
    val TELA_LISTAR_AFAZERES_ROTA = "listar_afazeres"
    val TELA_INCLUIR_AFAZER_ROTA = "incluir_afazer"
}


@Composable
fun TelaAfazeres(
    drawerState: DrawerState,
    navCtrlBottomNav: NavController
) {

    var afazeres = mutableListOf(
        Afazer(
            titulo = "Receita 1:",
            descricao = "Dieta Basica",
            id = 1
        ),
        Afazer(
            titulo = "Receita 2:",
            descricao = "Dieta Diferenciada",
            id = 2
        ),
        Afazer(
            titulo = "Receita 3:",
            descricao = "Dieta Exigente",
            id = 3
        )
    )

    val navCtrlTarefas = rememberNavController()


    Scaffold(
        topBar = { PlannerTopBar(drawerState) },
        content = { padding ->  padding
            NavHost(
                navController = navCtrlTarefas,
                startDestination = TarefasRota.TELA_LISTAR_AFAZERES_ROTA)
            {
                composable(TarefasRota.TELA_LISTAR_AFAZERES_ROTA) {
                    TelaListagemAfazeres(afazeres)
                }
                composable(TarefasRota.TELA_INCLUIR_AFAZER_ROTA) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Spacer(modifier = Modifier.height(200.dp))
                        Text(text = "TELA DE INCLUIR AFAZER")
                    }

                }
            }


        },
        bottomBar = { TelaUmBottomBar(navCtrlBottomNav) }
    )
}

@Composable
private fun TelaListagemAfazeres(afazeres: MutableList<Afazer>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(afazeres) { afazer ->
            Text(
                text = afazer.titulo,
                fontSize = 20.sp,
                )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = afazer.descricao,
                fontSize = 20.sp
            )
        }
    }
}

data class Afazer(
    var titulo: String,
    var descricao: String,
    var concluido: Boolean = false,
    var id: Int? = null
)



