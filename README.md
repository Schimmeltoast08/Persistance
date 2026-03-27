# Persistance
 A small tool to ensure Ai works through a large document cleanly, step by step.

# Installation
Either run the source code using 
```
java chatarr.java
```
Or download the **Linux** binary and run it using
```
./chatarr.run
```

# Usage
Enter a prompt and a step ammount. You are then given a new prompt which you can copy-paste into an ai agent or feed it to the ai directly using open-interpreter. Then copy paste the ai's output into the Programm. This will continue until the AI worked through the entire Document or until you write 'EOF'. After some more questions, you are given a List that should answer your prompt.

# Example
"On which pages of this document does the book say 'malware'?". Make sure you include a pdf file when first prompting the ai. You should get an output like [1,3,5,7,22,25,90].


