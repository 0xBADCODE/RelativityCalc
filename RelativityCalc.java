/*
	Relativity Calc - Xeon 2011
	Originally written in C++
*/

import java.util.Scanner;
import java.math.*;

class RelativityCalc {
	public static void main(String[] args) {

	final 	double 	m_proton = 1.6726215813e-27,
					m_neutron = 1.6749271613e-27,
					m_electron = 9.1093818872e-31,
					c_light = 2.99792458e8,
					evolt_conversion = 6.24150974e18; //1J in eV

			double	velocity = 3e8,
					mass = 0;

			int 	m = 0,
					v = 0;

	System.out.println("\n1. Rest mass of Proton   = " + m_proton + " kg\n"
					+"2. Rest mass of Neutron  = " + m_neutron + " kg\n"
					+"3. Rest mass of Electron = " + m_electron + " kg\n"
					+"4. Custom mass");


	Scanner scan = new Scanner(System.in),
			custom = new Scanner(System.in);
	String particle = new String("particle");

	while(m < 1 || m > 4) {
		System.out.print("\nPlease select your particle: ");	//select mass
		m = scan.nextInt();

		if (m == 1){ mass = m_proton;
						particle = new String("Proton");
		}
		if (m == 2){ mass = m_neutron;
						particle = new String("Neutron");
		}
		if (m == 3){ mass = m_electron;
						particle = new String("Electron");
		}
		if (m == 4){ System.out.print("Enter a mass in kg: ");
						mass = custom.nextDouble();
		}
		if (m < 1 || m > 4) System.out.println("Please choose an option 1-4");
	}
	//end mass

	System.out.println("\n1. 99.99% Speed of Light\n"
					+"2. 70 mph\n"
					+"3. 25000 mph\n"
					+"4. Custom velocity");

	while(v < 1 || v > 4) {
		while(velocity > c_light) {
			System.out.print("\nPlease select velocity of the " + particle + ": ");	//select velocity
			v = scan.nextInt();

			if (v == 1) velocity = c_light*0.9999;

			if (v == 2) velocity = 31.2928;

			if (v == 3) velocity = 11176;

			if (v == 4){ System.out.print("Enter a velocity in m/s: ");
							velocity = custom.nextDouble();
			}
			if (v < 1 || v > 4) System.out.println("Please choose an option 1-4");

			if (velocity > c_light) System.out.println("Tachyon. You broke physics."); //infitite loop issue
		}
	}

	//end velocity

	double  ratio = (velocity*velocity)/(c_light*c_light),
			gamma = 1.0/(Math.sqrt(1-ratio)),
			energy = mass*c_light*c_light,
			relativeenergy = gamma*mass*c_light*c_light,
			energydiff = (relativeenergy/energy)*100,
			evolt = (relativeenergy*evolt_conversion)/1e6;

	System.out.println("\nRest energy is " + energy + " joules.");
	System.out.println("Relativistic energy at " + velocity + " m/s is " + relativeenergy + " joules.");
	System.out.println(Math.round(energydiff) + "% of rest energy.\n");

	System.out.println("Rest mass is " + mass + " kg.");
	System.out.println("Relativistic mass at " + velocity + " m/s is " + gamma*mass + " kg.");
	System.out.println(Math.round(energydiff) + "% of rest mass.\n");

	System.out.println("Relative Mass-Energy equivalence = " + evolt + " MeV\n");

	//test data output
	System.out.println("Lorentz fuction (GAMMA) = " + gamma);
	System.out.println("Time dilation factor = " + 1/gamma);
	}
}
