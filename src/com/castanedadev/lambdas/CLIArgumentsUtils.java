package com.castanedadev.lambdas;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class CLIArgumentsUtils {
	static void showHelp(CLIArguments cliArgs) {
		Consumer<CLIArguments> consumerHelper = args -> {
			if(args.isHelp()) {
				System.out.println("User Manual requested!");
			}
		};
		
		consumerHelper.accept(cliArgs);	
		}
	
	static CLIArguments generateCLI() {
		Supplier<CLIArguments> generator = () -> new CLIArguments();
		return generator.get();
	}
}
