# Genetic algorithm
## Best Equipment

### Clonar y ejecutar

1) Abrir una terminal.

2) Ejecutar: `git clone git@github.com:meelrossi/genetic-algorithm.git`.

3) Cambiar al directorio: `cd genetic-algorithm/Equipment`.

4) Correr con el comando `java -jar genetic-algorithm.jar`.

### Configuracion

Existe un archivo de configuracion ubicado en la carpeta `files` con nombre `algorithm.properties`.

En el mismo, se puede configurar:

Configuracion para la poblacion y al k tomando en la seleccion:
```
population.size = 100
population.k = 50
```

Configuracion para el metodo de seleccion y porcentaje:
```
selection.one.type = Elite | Random | Roulette | Universal | Boltzmann | DeterministicTournament | ProbabilisticTournament | Ranking
selection.one.percentage = 0.2
selection.two.type = Elite | Random | Roulette | Universal | Boltzmann | DeterministicTournament | ProbabilisticTournament | Ranking
```

Configuracion para el metodo de reemplazo y porcentaje:
```
replacement.type = ChooseK | ChooseN | ReplaceAll
replacement.one.type = Elite | Random | Roulette | Universal | Boltzmann | DeterministicTournament | ProbabilisticTournament | Ranking
replacement.one.percentage = 0.1
replacement.two = Elite | Random | Roulette | Universal | Boltzmann | DeterministicTournament | ProbabilisticTournament | Ranking
```

Configuracion para la mutacion:
```
mutation.type = NonUniform | Classic
mutation.parameter = 1
```

Configuracion para el corte de la busqueda del fitness optimo:
```
cutoff.type = Structure | Content | Generation | Optimal
cutoff.parameter = 5000
```

Configuracion del metodo de combinacion para la cruza de cromosomas:
``` 
combination.type = OnePoint | TwoPoints | Anular | Uniform
```

Configuracion para seleccionar que elementos combinar en una generacion:
```
combination.selection = Combine2 | CombineAll | CombineRandom | CombineBest
```
Configuracion de semilla para el random utilizado:
```
seed = 38167053
```

