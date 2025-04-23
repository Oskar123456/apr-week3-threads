build:
	@mvn -q compile
run: build
	@mvn -q exec:java -Dexec.mainClass="ap_f2025.threads.opgave_3.Main"
