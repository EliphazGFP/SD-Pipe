# SD-PipesJava

Atividade: Comunicação entre threads usando Pipes (Padrão Produtor-Filtro-Consumidor)

## Objetivo
Demonstrar comunicação entre threads usando `PipedInputStream` e `PipedOutputStream`:
- **Produtor** gera números aleatórios
- **Filtro** calcula a média móvel
- **Consumidor** exibe a média atualizada

## Como compilar e executar

```bash
# Compilar tudo
javac *.java

# Executar com log (não sobrescreve)
java PipeTest > PipesExecucao_$(date +%Y%m%d_%H%M%S).log &

# Ou executar em foreground (recomendado para ver em tempo real)
java PipeTest

