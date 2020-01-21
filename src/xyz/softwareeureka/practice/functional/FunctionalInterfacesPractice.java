package xyz.softwareeureka.practice.functional;

import static java.lang.System.out;

// BiConsumer interface takes two arguments for processing.
import java.util.function.BiConsumer;

// BiFunction interface takes two arguments and produces a result.
import java.util.function.BiFunction;

// BinaryOperator interface takes two arguments and produces a result of the 
// same type as opposed to BiFunction which takes two arguments and produces a 
// result of a different type.
import java.util.function.BinaryOperator;

// Predicate interface takes a single argument. Then it produces a Boolean 
// result.
import java.util.function.Predicate;

// BiPredicate is like the Predicate interface. Although it takes Two arguments
// instead of the previous One. It then returns a Boolean result. 
import java.util.function.BiPredicate;

public class FunctionalInterfacesPractice
{
	
	
	
	
	public static void main(String[] args)
	{
		
		/**
		 * A BiConsumer interface accepts dual arguments.
		 */
		BiConsumer<Integer, Boolean> dual_args_literal_function = (number_to_process, process_now) -> {
			if(process_now)
				out.println("(BiConsumer)Processed number:" + (number_to_process *= 2));
		};
		
		// Execute our dual argument functional interfaces.
		dual_args_literal_function.accept(20, false);
		dual_args_literal_function.accept(20, true);
		
		
		/**
		 * A BiFunction interface accepts dual arguments in order to produce 
		 * a result.
		 */
		BiFunction<Integer, Integer, Integer> dual_args_for_result_literal_function = (number_to_process, multiplier) -> 
			{return number_to_process * multiplier;};
			
		// Execute our dual argument functional interface and receive the result.
		final int result = dual_args_for_result_literal_function.apply(10, 100);
		out.println("(BiFunction)Returned processed number:" + result);
		
		/**
		 * A BinaryConsumer interface accepts Two arguments however it only accepts
		 * a single type argument. This means each argument and the result must be of
		 * same type. 
		 */
		BinaryOperator<Double> dual_args_for_result_without_result_type = (number_to_process, multipler) ->
			{return number_to_process * multipler;};
		
		// Execute our dual argument functional interface and retrieve the result.
		final double result_of_binary_operator = dual_args_for_result_without_result_type.apply(30d, 2.5d);
		out.println("(BinaryOperator)Returned processed number:" + result_of_binary_operator);
		
		
		/**
		 * Predicate takes a single type and then returns a Boolean value
		 * after doing something with the type.
		 */
		Predicate<PredicatePayload> predicate_literal = (payload) -> 
		{
			final boolean is_bi_predicate = false;
			return payload.doStuff(is_bi_predicate);
		}; 

		// Execute our literal function predicate and pass through the
		// required data type to process.
		predicate_literal.test(new PredicatePayload());
		
		/**
		 * BiPredicate accepts dual arguments of distinct types and uses each one to 
		 * determine the result of a boolean type.
		 */
		BiPredicate<PredicatePayload, PredicatePayload> bipredicate_literal = (payload_0, payload_1) ->
		{
			final boolean is_bi_predicate = true;
			return (payload_0.doStuff(is_bi_predicate) && payload_1.doStuff(is_bi_predicate));
		};
		
		// Execute our BiPredicate function
		bipredicate_literal.test(new PredicatePayload(), new PredicatePayload());
	}


	private static class PredicatePayload
	{
		private boolean doStuff(final boolean is_bi)
		{
			final String functional_type = (is_bi) ? "(BiPredicate)" : "(Predicate)";
			out.println(functional_type+"Doing Stuff.");
			return true;
		}
	}
}