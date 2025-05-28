# Karaokê JavaFX 🎤🎶

Este é um projeto de **Karaokê Desktop Offline** desenvolvido em **Java** com **JavaFX**, que possui uma interface gráfica simples e intuitiva. Nele, o usuário insere o número da música, o programa busca na pasta de vídeos um arquivo `.mp4` correspondente e inicia automaticamente a reprodução em uma tela de player personalizada.

## 🛠️ Tecnologias utilizadas

- Java
- JavaFX
- Maven (para gerenciamento de dependências)
- Biblioteca JavaFX Media (para reprodução de vídeo)

## 🚀 Funcionalidades

- Interface gráfica desenvolvida com JavaFX.
- Campo de input para digitar o número da música.
- Busca automática por arquivos de vídeo (`.mp4`) em uma pasta local.
- Ao encontrar o arquivo, troca a tela para um player de vídeo.
- Reprodução do vídeo diretamente dentro do aplicativo.
- Funciona offline, ideal para uso em eventos, festas ou uso pessoal.

## 🎥 Organização dos Arquivos

Os vídeos precisam estar organizados em uma pasta específica, onde os arquivos seguem o padrão de nomenclatura baseado no número da música.

### 📁 Estrutura recomendada:

├── videos/
│ ├── 0001.mp4
│ ├── 0002.mp4
│ ├── 0123.mp4
│ └── ...

