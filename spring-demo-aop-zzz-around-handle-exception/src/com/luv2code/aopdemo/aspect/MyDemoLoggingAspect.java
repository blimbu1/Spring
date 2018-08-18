package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = 
			Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortuneService(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n========================>>>Executing @Around  on method: " + method);	
		
		//begin time
		long begin = System.currentTimeMillis();
		
		//lets execute the method. The command below exectues the target method.
		Object result = null;
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			// log the exception
			myLogger.warning(e.getMessage());
			
			
			/***
			// give user a custom message i.e handle exception
			result = "Major accident ! But no worries, " + "your private AOP helicopter is on the way";
		**/
			//rethrow the exception
			throw e;
		}
		
		// get time
		long end = System.currentTimeMillis();
		
		//compute time
		long timetaken = end - begin;
		
		
		myLogger.info("\n===============> Duration : " + timetaken/1000.0 + " seconds ");
		
		return result;// check result above
		
		
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		// print out which method we are advising on 
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n========================>>>Executing @After (finally) on method: " + method);		
	}
	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc"
			)
	public void afterThrowingFindAccountsAdvice(
			JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out which method we are advising on 
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n========================>>>Executing @AfterReturning on method: " + method);
		
		// log the exception
		myLogger.info("\n=========================>>>The exception is: " + theExc);
		
	}
	
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(
					JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n========================>>>Executing @AfterReturning on method: " + method);
		// print out the results of method call
		myLogger.info("\n========================>>>result is: " + result);
		
		// let's post-process the data ... let's modify it :-)
		
		// convert the account names to uppercase
		converAccountNamesToUpperCase(result);
		
		myLogger.info("\n========================>>>result is: " + result);

		

	}
	
	
	private void converAccountNamesToUpperCase(List<Account> result) {
		
		// loop through accounts
		
		for (Account tempAccount : result) {
			// get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			// update the name on the account
			tempAccount.setName(theUpperName);
			
		}
		
		
		// update the name on the account
	}


	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n===================>>> Executing @Before advice on method");
		
		// display the method signature
		
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method: " + methodSig);
		
		// display method arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru args
		for (Object tempArg : args) {
			myLogger.info(tempArg.toString());
			
			if (tempArg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				myLogger.info("account name: "  + theAccount.getName());
				myLogger.info("account level: " + theAccount.getLevel());
			}
		}
	}
	
}
