function roundRobin(processes, timeQuantum) {
  let currentTime = 0;
  let queue = [];
  let totalWaitingTime = 0;
  let totalTurnaroundTime = 0;

  // Add all processes to the queue in arrival order
  processes.sort((a, b) => a.arrivalTime - b.arrivalTime);
  processes.forEach(process => process.remainingTime = process.burstTime);

  while (processes.length > 0) {
      const process = processes.shift();

      if (process.remainingTime > timeQuantum) {
          // Execute for time quantum
          currentTime += timeQuantum;
          process.remainingTime -= timeQuantum;
          // Re-add process to the queue if it's not finished
          processes.push(process);
      } else {
          // Execute for remaining time
          currentTime += process.remainingTime;
          process.remainingTime = 0;

          // Completion Time
          process.completionTime = currentTime;

          // Turnaround Time = Completion Time - Arrival Time
          process.turnaroundTime = process.completionTime - process.arrivalTime;

          // Waiting Time = Turnaround Time - Burst Time
          process.waitingTime = process.turnaroundTime - process.burstTime;

          totalWaitingTime += process.waitingTime;
          totalTurnaroundTime += process.turnaroundTime;
      }
  }

  console.log("Processes:", processes);
  console.log("Average Waiting Time:", totalWaitingTime / queue.length);
  console.log("Average Turnaround Time:", totalTurnaroundTime / queue.length);
}

// Example Usage
const processesRR = [
  { id: "P1", arrivalTime: 0, burstTime: 6 },
  { id: "P2", arrivalTime: 2, burstTime: 4 },
  { id: "P3", arrivalTime: 4, burstTime: 2 }
];

roundRobin(processesRR, 2); // Time Quantum = 2
