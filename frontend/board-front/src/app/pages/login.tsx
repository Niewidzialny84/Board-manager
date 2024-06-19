"use client"
import React, { useState } from 'react';

interface LoginInput {
  name: string;
  key: string;
}

function Login(): React.FC {
  const [formData, setFormData] = useState<LoginInput>({
    name: '',
    key: '',
  });
  const [errorMessage, setErrorMessage] = useState<string | null>(null);

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();

    // Implement your name and key validation logic here
    // For example, call an API endpoint to verify credentials
    // and handle success/failure scenarios

    if (formData.name === 'valid_name' && formData.key === 'secret_key') {
      // Login successful (replace with your desired action)
      console.log('Login successful!');
    } else {
      setErrorMessage('Invalid name or key');
    }
  };

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setFormData({ ...formData, [event.target.name]: event.target.value });
  };

  return (
    <div className="login-container container mx-auto p-4">
      <h1 className="text-3xl font-bold mb-4">Login</h1>
      <form onSubmit={handleSubmit} className="flex flex-col gap-4">
        <label htmlFor="name" className="text-gray-700">
          Name:
        </label>
        <input
          type="text"
          id="name"
          name="name"
          value={formData.name}
          onChange={handleChange}
          required
          className="rounded-md border border-gray-300 px-3 py-2 focus:outline-none focus:ring-1 focus:ring-blue-500"
        />
        <label htmlFor="key" className="text-gray-700">
          Key:
        </label>
        <input
          type="password" // Change to "text" for development purposes
          id="key"
          name="key"
          value={formData.key}
          onChange={handleChange}
          required
          className="rounded-md border border-gray-300 px-3 py-2 focus:outline-none focus:ring-1 focus:ring-blue-500"
        />
        <button
          type="submit"
          className="bg-blue-500 text-white py-2 px-4 rounded-md hover:bg-blue-700"
        >
          Enter
        </button>
      </form>
      {errorMessage && <p className="text-red-500 text-center">{errorMessage}</p>}
    </div>
  );
}

export default Login;